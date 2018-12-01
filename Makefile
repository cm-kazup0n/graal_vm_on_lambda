image:
	docker build . -t kazup0n/graalvm

jar:
	gradle clean shadowJar
	docker run -v(pwd):/home --rm kazup0n/graalvm  'cd /home; /opt/graalvm-ce-1.0.0-rc9/bin/native-image -H:ReflectionConfigurationFiles=reflectconfig.json -jar /home/build/libs/handler-1.0-SNAPSHOT-all.jar'
	mv handler-1.0-SNAPSHOT-all functions/handler
function:
	rm functions.zip
	zip -j functions.zip functions/*
	aws lambda delete-function --function-name graalvm-native
	aws lambda create-function --function-name graalvm-native \
	--zip-file fileb://functions.zip \
	--handler "handler" \
	--runtime provided \
	--role arn:aws:iam::331282901948:role/service-role/graalvm-native-lambda

invoke:
	@aws lambda invoke --function-name graalvm-native --payload '{"name":"world", "place": "sapporo"}' response.txt
	@cat response.txt | jq .

