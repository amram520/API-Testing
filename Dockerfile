FROM maven:3.9.4-eclipse-temurin-17 AS builder
# Use a base image with JDK (you can choose openjdk:17 if you need Java 17 or other as per your project requirements)


# Set environment variables for Playwright to avoid downloading browsers from Microsoft's CDN
ENV PLAYWRIGHT_BROWSERS_PATH=/ms-playwright
#ENV PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD=1

# Install dependencies for Playwright
#RUN apt-get update && \
#    apt-get install -y wget gnupg && \
#    apt-get install -y \
#    libnss3 \
#    libxss1 \
#    libasound2 \
#    libx11-xcb1 \
#    libatk-bridge2.0-0 \
#    libgtk-3-0 \
#    libdrm2 \
#    libgbm1 \
#    libxcomposite1 \
#    libxrandr2 \
#    libpangocairo-1.0-0 \
#    libcups2 \
#    libatk1.0-0 \
#    libatspi2.0-0 \
#    xdg-utils && \
#    rm -rf /var/lib/apt/lists/*

# Set up Maven
#RUN apt-get update && \
#    apt-get install -y maven && \
#    rm -rf /var/lib/apt/lists/*

# Add Maven's settings.xml if you want to configure your internal Artifactory for dependencies
#COPY settings.xml /usr/share/maven/ref/

# Copy your project files into the container
WORKDIR /app
COPY . /app
#RUN mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install-deps"
#RUN mvn playwight:install
# Run Maven to install dependencies and package the project
RUN mvn clean install -DskipTests

# Set up a default command to run your tests
CMD ["sh", "-c","mvn test -Dfile=$TEST_NAME"]

