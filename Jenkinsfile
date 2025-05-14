pipeline {
agent any
tools {
maven 'MAVEN399'
jdk 'JDK21'
}
stages {
stage ('Compile Stage') {
steps {
withMaven(maven : 'MAVEN399') {
bat 'mvn clean compile'
}
}
}
stage ('Testing Stage') {
steps {
withMaven(maven : 'MAVEN399') {
bat 'mvn test'
}
}
}
stage ('package Stage') {
steps {
withMaven(maven : 'MAVEN399') {
bat 'mvn package'
}
}
}
}
}