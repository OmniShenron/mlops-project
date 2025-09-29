FROM jenkins/jenkins:lts

# Skip setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# Copy plugins.txt
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt

# Install plugins first
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Copy Groovy scripts
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/default-user.groovy
COPY pipeline-job.groovy /usr/share/jenkins/ref/init.groovy.d/pipeline-job.groovy
