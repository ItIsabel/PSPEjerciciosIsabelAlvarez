# Building a Multi-Service Application with In-Place Upgrades on Kubernetes

This assignment focuses on deploying a multi-service application using Kubernetes, specifically involving a FastAPI backend and a Node.js frontend. Key concepts include containerization, deployments, services, networking, scaling, and in-place upgrades via rolling updates.

## Application Overview

The application consists of two main services:

### Backend API Service (FastAPI):

* Provides REST endpoints (e.g., /, /status).
* Containerized using a Dockerfile.
* The upgrade scenario involves modifying the API to display a new version message and performing an in-place (rolling) update without downtime.

### Frontend Service (Node.js):

* A simple web interface that interacts with the backend API.
* Containerized separately.

## Installation and Running the Application:

1.  **Start the Local Kubernetes Environment:**
    * Begin by launching Minikube, a tool that creates a small, local Kubernetes cluster.

2.  **Deploy the Application to Kubernetes:**
    * Next, apply the Kubernetes configuration files in the specified order to deploy the backend and frontend services and their respective service definitions. This effectively tells Kubernetes to create the necessary components.

3.  **Verify the Application is Running:**
    * Check the status of the running application components (pods) and services within Kubernetes to ensure everything is operating correctly.

4.  **Access the Frontend:**
    * Retrieve the web address (URL) of the frontend service from Minikube.
    * Open this URL in a web browser to view and interact with the application's user interface.
  

## Kubernetes Operations

The following Kubernetes commands were used:

### Images:
after building the image on Docker, load it in minikube
    ```bash
    minikube image load my-fastapi:v2
    ```
    
### Deployments & Services

* **Deleting Deployments:**

    ```bash
    kubectl delete deployment backend-deployment
    kubectl delete deployment frontend-deployment
    ```

* **Creating Deployments:**

    ```bash
    kubectl apply -f backend-deployment.yaml
    kubectl apply -f frontend-deployment.yaml
    ```

* **Creating Services:**

    ```bash
    kubectl apply -f backend-service.yaml
    kubectl apply -f frontend-service.yaml
    ```

* **Deleting Services:**

    ```bash
    kubectl delete service backend-service
    ```

* **Updating Deployments (Rolling Update):**

    ```bash
    kubectl set image deployment/backend-deployment backend=my-fastapi:v2
    kubectl rollout status deployment/backend-deployment
    ```

    * `kubectl set image deployment/backend-deployment backend=my-fastapi:v2`
        * `deployment/backend-deployment`: Deployment name.
        * `backend`: container name.
        * `my-fastapi:v2`: new image tag.

* `kubectl rollout status deployment/backend-deployment` : displays the rollout status.

### Pods

* **Deleting Pods:**

    ```bash
    kubectl delete pods -l app=frontend
    kubectl delete pods --all
    ```

* **Listing Pods:**

    ```bash
    kubectl get pods
    ```

* **Describing Pods:**

    ```bash
    kubectl describe pod backend-deployment-6f76f5dd54-w7qnx
    ```

### Logs

* **Viewing Logs:**

    ```bash
    kubectl logs backend-deployment-6f76f5dd54-wzb9h
    ```


### Errors

* **ImagePullBackOff:**

    * This error typically indicates an issue with pulling the container image.
    * Solution: log into the container registry (`docker login`).

### Other:
expose kubernetes service port from localhost:
*  kubectl port-forward service/frontend-service 3000:80
