#!/bin/sh

# disable user certificate
gcloud config unset container/use_client_certificate
# access cluster
gcloud container clusters get-credentials salt-cluster --zone asia-southeast1-a --project isp-chat-app
# pull image
docker pull wisatong/saltwater:0.7.2-SNAPSHOT
# set new image to deployment
kubectl set image deployment/salt-web salt-web=wisatong/saltwater:0.7.2-SNAPSHOT
# view successful deployment
kubectl get services
