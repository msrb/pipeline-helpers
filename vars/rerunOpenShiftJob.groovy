#!/usr/bin/groovy

def call() {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    sh "oc --context=${cluster} get job ${jobName} --export=true --output=yaml > ${jobName}.yaml"
    sh "oc --context=${cluster} delete job ${jobName}"
    sh "oc --context=${cluster} create -f ${jobName}.yaml"
}

