FROM ubuntu:18.04
RUN apt-get update -y && apt-get install -y nginx curl vim
# COPY ./scripts/testentrty.sh /
# RUN /testentrty.sh
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]