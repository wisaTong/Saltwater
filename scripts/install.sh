#!/bin/sh

# install kubectl
curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
chmod +x ./kubectl
sudo mv ./kubectl /usr/local/bin/kubectl

# download .kube/config
curl -o config https://$GITHUB_ACCESS_TOKEN@raw.githubusercontent.com/wisaTong/Saltwater/feature-automate-deployment/.kube/config

mkdir ${HOME}/.kube
cp config ${HOME}/.kube/config
