# Scratch Kubernetes
This is a draft project implementing Scratch blocks to interact with Kubernetes.

This project is composed of:
- `quarkus-kubernetes-client-service` located in this repo: a simple REST application that exposes kubernetes actions to scratch.
- `scratch-vm` a fork of the original scratch-vm + the scratch k8s library with the implementation of the k8s custom blocks.
- `scratch-gui` a fork of the original scratch-gui + the declaration of the scratch k8s library.

## Run in Developer Sandbox
Developer Sandbox is a Red Hat OpenShift cluster to deploy your application code as a container on this self-service, cloud-hosted experience. Skip installations and deployment and jump directly into OpenShift.

1. Get registered if not:  https://developers.redhat.com/developer-sandbox
2. Start the workspace: [![Contribute](https://raw.githubusercontent.com/redhat-developer-demos/quarkus-reactjs-postit-app/master/factory-contribute.svg)](https://workspaces.openshift.com/f?url=https://github.com/sunix/scratch-kubernetes)


## Run in your own Che instance

Run that with your own Eclipse Che instance:

```
https://<che-host>/factory?url=https://github.com/sunix/scratch-kubernetes
```

Fork this repo and replace `workspaces.openshift.com` with your che host:
<a href="https://workspaces.openshift.com/factory?url=https://github.com/sunix/scratch-kubernetes"><img src="https://raw.githubusercontent.com/redhat-developer-demos/quarkus-reactjs-postit-app/master/factory-contribute.svg" /></a>
