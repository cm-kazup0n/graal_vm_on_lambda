FROM amazonlinux:2

# install dependencies
RUN yum update -y && yum install -y tar gzip gcc zlib-devel

# download graalvm
RUN curl -L https://github.com/oracle/graal/releases/download/vm-1.0.0-rc9/graalvm-ce-1.0.0-rc9-linux-amd64.tar.gz | tar zx -C /opt


