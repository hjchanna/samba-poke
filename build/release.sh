#!/usr/bin/env bash

# create and push tags
git tag build/$CIRCLE_BUILD_NUM
git push --tags

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
