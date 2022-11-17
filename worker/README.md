# Algo space worker base image

## This Dockerfile was created to be used for creating base image for worker executing code prepared by user.

### To build and push this image execute below commands in current (worker) directory
```bash
docker login -u algospacezpi -p algospace123$
docker build -t algospacezpi/algospace-worker .
docker push algospacezpi/algospace-worker
```
