# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.222.0/containers/ubuntu/.devcontainer/base.Dockerfile

# [Choice] Ubuntu version (use hirsuite or bionic on local arm64/Apple Silicon): hirsute, focal, bionic
ARG VARIANT="hirsute"
FROM mcr.microsoft.com/vscode/devcontainers/base:0-${VARIANT}

# [Optional] Uncomment this section to install additional OS packages.
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends rlwrap leiningen

RUN curl -O https://download.clojure.org/install/linux-install-1.10.3.1087.sh && chmod +x linux-install-1.10.3.1087.sh && sudo ./linux-install-1.10.3.1087.sh


