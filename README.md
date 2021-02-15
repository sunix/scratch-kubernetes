# Scratch Kubernetes

[![Contribute](https://raw.githubusercontent.com/redhat-developer-demos/quarkus-reactjs-postit-app/master/factory-contribute.svg)](https://workspaces.openshift.com/f?url=https://github.com/sunix/scratch-kubernetes)

This is a draft project implementing Scratch blocks to interact with Kubernetes.

This project is composed of:
- `quarkus-kubernetes-client-service` located in this repo: a simple REST application that exposes kubernetes actions to scratch.
- `scratch-vm` a fork of the original scratch-vm + the scratch k8s library with the implementation of the k8s custom blocks.
- `scratch-gui` a fork of the original scratch-gui + the declaration of the scratch k8s library.

Run that with your own Eclipse Che instance:

```
https://<che-host>/factory?url=https://github.com/sunix/scratch-kubernetes
```

Fork this repo and replace `workspaces.openshift.com` with your che host:
<a href="https://workspaces.openshift.com/factory?url=https://github.com/sunix/scratch-kubernetes"><img src="https://raw.githubusercontent.com/redhat-developer-demos/quarkus-reactjs-postit-app/master/factory-contribute.svg" /></a>
