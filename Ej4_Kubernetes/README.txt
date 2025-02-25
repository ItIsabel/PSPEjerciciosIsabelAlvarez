# Building a Multi-Service Application with In-Place Upgrades on Kubernetes

The assignment focuses on deploying a multi-service application using Kubernetes, specifically involving a FastAPI backend and a Node.js frontend. Key concepts include containerization, deployments, services, networking, scaling, and in-place upgrades via rolling updates. 



## Application Overview
The application consists of two main services:

### Backend API Service (FastAPI): 
Provides REST endpoints (e.g., /, /status) and is containerized using a Dockerfile. The upgrade scenario involves modifying the API to display a new version message and performing an in-place (rolling) update without downtime. 

### Frontend Service (Node.js): 
A simple web interface that interacts with the backend API and is containerized separately.



## The methods used are:

### DEPLOYMENTS & SERVICES

#### borrar los deployments para que dejen de recrearse los pods cuando los eliminas
kubectl delete deployment backend-deployment
kubectl delete deployment frontend-deployment

#### crear los deployments 
 
kubectl apply -f frontend-deployment.yaml

#### crear los services
kubectl apply -f backend-service.yaml
kubectl apply -f frontend-service.yaml

#### delete services 
kubectl delete service backend-service

#### Actualizar el deployment con una imagen nueva
1) kubectl set image deployment/backend-deployment backend=my-fastapi:v2
                             ^nombreDeployment          ^nombreImagen     
2) kubectl rollout status deployment/backend-deployment


### PODS

#### borrar los pods:
kubectl delete pods -l app=frontend
kubectl delete pods --all

#### listar los pods
kubectl get pods

#### mostrar datos del pod:
kubectl describe pod backend-deployment-6f76f5dd54-w7qnx


### LOGS:
Ver los logs
kubectl logs backend-deployment-6f76f5dd54-wzb9h


### ERRORES:
if ImagePullBackOff -->docker login



## VARIOS - IMPORTANTE
una vez creada la imagen en Docker
minikube image load my-fastapi:v1


Mostrar front con localhost:3000
 kubectl port-forward service/frontend-service 3000:80