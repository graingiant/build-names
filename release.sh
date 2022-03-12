#!/bin/bash
LATEST_TAG=git describe --tags $(git rev-list --tags --max-count=1)
tar -cxvf  build-names-$TAG target/default/build-names