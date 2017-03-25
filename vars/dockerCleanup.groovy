#!/usr/bin/groovy

def call() {
    sh 'docker rm -vf $(docker ps -qa)'
}

