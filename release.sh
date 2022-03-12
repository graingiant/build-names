#!/bin/bash
LATEST_TAG=`git describe --tags $(git rev-list --tags --max-count=1)`
tar -czvf  build-names-$LATEST_TAG.tar.gz target/default/build-names