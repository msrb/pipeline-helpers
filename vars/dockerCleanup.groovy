#!/usr/bin/groovy

def call() {
    def containers = sh 'docker ps -qa', returnStdout=true
    sh "docker rm -vf ${containers.trim()}"
}

