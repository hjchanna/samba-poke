#!/usr/bin/env bash

# download ghr
wget -c https://github.com/tcnksm/ghr/releases/download/v0.5.4/ghr_v0.5.4_linux_amd64.zip
unzip ghr_v0.5.4_linux_amd64.zip
mv ghr bin


# release api
curl -X POST \
  https://api.github.com/repos/hjchanna/samba-poke/releases \
  -H 'authorization: token b1bd90f64d206380ef4bb74516f8664a487f720a' \
  -H 'content-type: application/json' \
  -d '{
  "tag_name": "build/$CIRCLE_BUILD_NUM",
  "target_commitish": "master",
  "name": "$CIRCLE_BUILD_NUM",
  "body": "Description of the release",
  "draft": false,
  "prerelease": false
}'
