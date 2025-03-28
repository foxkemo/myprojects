#!/bin/bash

echo "this script will download clash for windows gui continue(y)?"
read choice
if [ "$choice" = "y" ]
then
  curl -O https://down.gtk.pw/proxy/linux/Clash.for.Windows-0.18.5-x64-linux.tar.gz
  tar -x ./Clash.for.Windows-0.18.5-x64-linux.tar.gz
  mv Clash.for.Windows-0.18.5-x64-linux.tar.gz clash
  mv clash /opt
  vim ~/.bashrc
  echo "i"
else
  exit
fi
echo "this script will install git (y)?"
read choice
if [ "$choice" = "y" ]
then
sudo yum install git
else
  exit
fi
echo "this script will install npm (y)?"
read choice
if [ "$choice" = "y" ]
then
sudo yum install npm
else
  exit
fi
echo "install java sdk 17(y)?"
read choice
if [ "$choice" = "y" ]
then
sudo yum install java-17-openjdk
else
  exit
fi
