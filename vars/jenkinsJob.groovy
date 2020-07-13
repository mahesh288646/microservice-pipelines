def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("deploy")){
            packageArtifact()
        } else if(env.JOB_NAME.contains("test")) {
            buildAndTest()
        }
    }
}

def packageArtifact(){
    stage("Package artifact") {
        //sh "mvn package"
		sh "echo Package Artifact"
    }
}

def buildAndTest(){
    stage("Backend tests"){
        //sh "mvn test"
		sh "echo Backend tests"
    }
}