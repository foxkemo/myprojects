#!/bin/bash
hexo g -d
cd ../foxkemo.github.io/
git rm -r .
cp -r ../myprojects/myblog/public/* .
git add *
git commit -m "update"
git push
cd  ../myprojects                                  
git add *
git commit -m meow
git push
