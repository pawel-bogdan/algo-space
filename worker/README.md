# Algo space worker base image

## This Dockerfile was created to be used for creating base image for worker executing code prepared by user.

### To build and push this image execute below commands in current (worker) directory
```bash
docker login -u algospacezpi -p algospace123$
docker build -t algospacezpi/algo-space-worker:1.0 .
docker push algospacezpi/algo-space-worker:1.0
```
