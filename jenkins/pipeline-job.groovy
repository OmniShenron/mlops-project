import jenkins.model.Jenkins

def plugin = Jenkins.instance.getPluginManager().getPlugin("workflow-aggregator")
if(plugin == null) {
    println("Pipeline plugin not installed yet. Skipping job creation.")
    return
}

import org.jenkinsci.plugins.workflow.job.WorkflowJob
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition

def jobName = "ml-training-pipeline"
if(Jenkins.instance.getItem(jobName) == null){
    def job = Jenkins.instance.createProject(WorkflowJob, jobName)
    def jenkinsfilePath = "/var/jenkins_home/Jenkinsfile"
    job.definition = new CpsFlowDefinition(new File(jenkinsfilePath).text, true)
    job.save()
    println("Created job: ${jobName}")
}
