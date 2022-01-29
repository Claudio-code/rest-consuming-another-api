FROM node:16-bullseye-slim

COPY data.json /usr/src/

COPY entrypoint.sh /

RUN npm install -g @mockoon/cli

RUN chmod +x /entrypoint.sh

EXPOSE 3000

CMD [ "./entrypoint.sh" ]