FROM maven:3.9.6-eclipse-temurin-17

# Install Chrome + ChromeDriver + utilities
RUN apt-get update && apt-get install -y wget gnupg2 unzip curl \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" \
         > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && DRIVER_VERSION=$(curl -s "https://chromedriver.storage.googleapis.com/LATEST_RELEASE") \
    && wget -q "https://chromedriver.storage.googleapis.com/$DRIVER_VERSION/chromedriver_linux64.zip" \
    && unzip chromedriver_linux64.zip -d /usr/local/bin \
    && rm chromedriver_linux64.zip

# Install Allure CLI
RUN wget https://github.com/allure-framework/allure2/releases/download/2.26.0/allure-2.26.0.zip -O /tmp/allure.zip \
    && unzip /tmp/allure.zip -d /opt/ \
    && ln -s /opt/allure-2.26.0/bin/allure /usr/bin/allure \
    && rm /tmp/allure.zip

WORKDIR /project
COPY . /project

# Run tests and generate Allure report
CMD mvn clean test -Dheadless=true && \
    mkdir -p target/allure-report && \
    if [ -d target/allure-results ] && [ "$(ls -A target/allure-results)" ]; then \
        allure generate target/allure-results -o target/allure-report --clean; \
    else \
        echo "No Allure results found, skipping report generation"; \
    fi
