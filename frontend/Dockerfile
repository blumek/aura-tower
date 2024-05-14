FROM node:22.1.0 AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM nginx:1.26-alpine AS ngx
COPY --from=build /app/dist/aura-tower/browser /usr/share/nginx/html
COPY /nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
