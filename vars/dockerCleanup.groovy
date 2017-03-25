#!/usr/bin/groovy

def call() {
    def containers = sh 'docker ps -qa', returnStdout=True
    sh "docker rm -vf ${containers.trim()}"
}

