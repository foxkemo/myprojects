!/bin/bash
hexo g  
cd  ../../foxkemo.github.io/
git rm -r .
cp -r ../myprojects/myblog/public/* .
git add *
git commit -m "update"
git push                                  
                                 
