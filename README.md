
Before running containers, it is needed to create new docker network named 'selenoid' via:
```
docker network create selenoid
```
After that run docker-compose via:
```
docker-compose up
```
You can check containers availability via:
```
docker-compose exec jenkins curl selenoid:4444
```
It should return 'You are using Selenoid $(version)!'

If you have problems with Selenoid internal network. For example 'wait: http://172.17.0.2:4444 does not respond in 30s', then turn off 'Use Docker Compose V2' setting in Docker.