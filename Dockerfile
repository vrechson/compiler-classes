FROM openjdk:16-alpine

RUN apk add python3 gcc

WORKDIR /usr/src/compiler

COPY . .

ENTRYPOINT [ "python3", "la.py" ]

