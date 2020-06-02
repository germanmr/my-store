read -r -p "Warning!!! This will clean all images and containers in your local Docker Desktop, Would you like to continue? [y/N] " response
if [[ "$response" =~ ^([nN])$ ]]
then
  exit;
fi

echo "Clean and launch locally the docker compose"
echo "------------------------------------------------"
echo "Kill all running containers"
docker container kill $(docker ps -q)
echo "------------------------------------------------"
echo "Delete all containers that are not running"
docker container rm $(docker ps -a -q)
echo "------------------------------------------------"
echo "Delete all images"
docker rmi $(docker images -a -q) -f
echo "------------------------------------------------"
echo "Build the Jar"
mvn clean install -Dmaven.test.skip=true
echo "------------------------------------------------"
echo "Copy the docker file"
#cp Dockerfile target/Dockerfile
echo "------------------------------------------------"
echo "Build the image"
#docker build -t my-store target/
echo "------------------------------------------------"
echo "Starting with docker-compose"
docker-compose up
# Remove docker image from dockerHub
#	curl -X DELETE -u "german1982:tato29001807" https://index.docker.io/v1/repositories/german1982/my-store/

# docker image tag my-store german1982/my-store
# We have to tag the image with german1982/ before!
#	docker image tag my-store german1982/my-store
# Upload to docker Hub
#	docker image push german1982/my-store

############################################################################
#				Stand alone modes!!!
#
#Run redis ( and pull ):
#	docker run -d -p 6379:6379 redis
#
#Docker run image alone:
#	docker container run -p 8080:8080 -d my-store
