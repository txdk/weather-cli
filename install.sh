#!/bin/bash

JAR_NAME="weather-cli-1.0.jar"
JAR_PATH="$(pwd)/target/$JAR_NAME"

./mvnw clean package

CURRENT_ALIAS=$(cat $HOME/.bash_profile | grep "alias weather")
NEW_ALIAS="alias weather=\"java -jar $JAR_PATH\""

if [[ -z $CURRENT_ALIAS ]];
then echo $NEW_ALIAS >> $HOME/.bash_profile;
else sed -E "s~(alias weather=).*~$NEW_ALIAS~g" $HOME/.bash_profile > $HOME/.bash_profile_tmp && mv $HOME/.bash_profile_tmp $HOME/.bash_profile;
fi