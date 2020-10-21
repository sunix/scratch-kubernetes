# Scratch blocks to interact with Kubernetes
Welcome to this demo to add new blocks to Scratch to interact with your Kubernetes cluster.

## Before you start
Make sure that you are connected into a valid Kubernetes cluster
(for instance with the [Openshift view](didact://?commandId=plugin.view-container.openshiftView.toggle
) or [Kubernetes view](didact://?commandId=plugin.view-container.kubernetesView.toggle)).

## Setup and start the project
### Compile and start Scratch with Kubernetes blocks
To start, run the 3 predifined commands, either:
- From the [My Workspace view on the right](didact://?commandId=plugin.view-container.my-workspace.toggle)
- Or by clicking on the commands below:
  - [1. install all required dependencies](didact://?commandId=workbench.action.tasks.runTask&text=1.%20Install%20all%20required%20dependencies)
  - [2. Start Scratch-gui in Devmode](didact://?commandId=workbench.action.tasks.runTask&text=2.%20Start%20Scratch-gui%20in%20Devmode)
  - [3. Start Development mode (Hot reload + debug)](didact://?commandId=workbench.action.tasks.runTask&text=3.%20Start%20Development%20mode%20%28Hot%20reload%20%2B%20debug%29)

Open the URL provided by the last command.

### Playing with Scratch and the Kubernetes blocks
You should see Scratch running. By the default, the K8S blocks are not available.
- Click on the icon to add libraries,
- Select Kubernetes
- You should have a new block category named `Kubernetes`
- Play with it :)

## Add your own Kubernetes blocks
- [Open KubernetesClientService.java](didact://?commandId=vscode.open&projectFilePath=quarkus-kubernetes-client-service%2Fsrc%2Fmain%2Fjava%2Forg%2Feclipse%2Fche%2Fkubernetes%2FKubernetesClientService.java&number=2) to code the Quarkus RestAPI that will interact with Kubernetes
- [Open scratch-vm / extensions / scratch3_k8s / index.js](didact://?commandId=vscode.open&projectFilePath=scratch-vm%2Fsrc%2Fextensions%2Fscratch3_k8s%2Findex.js&number=2) to customize or add new blocks
