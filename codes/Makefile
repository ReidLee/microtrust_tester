BIN_PATH=bin
SOURCEPATH=src
LIB_PATH=lib
SOURCELIST=file_list
OUTPUT_PATH=out
JAR_TARGET=test.jar
ANDROID_JAR_TARGET=target.jar
MANIFEST=manifest.mf
INSTALL_PATH=/data/local/tmp/
JARS=$(LIB_PATH)/android5.0.jar
MAIN_CLASS=microtrust.Main
RUN_SHELL_PATH=runjar.sh
FILE_LIST_NAME=file_list


build:
	@-mkdir $(OUTPUT_PATH)
	@echo "Main-Class: $(MAIN_CLASS)" > $(MANIFEST)
	@find ./ -name *.java | tee $(FILE_LIST_NAME)
	@javac -classpath  $(JARS) -sourcepath $(SOURCEPATH) @$(SOURCELIST) -d $(OUTPUT_PATH)
	@jar cvfm $(JAR_TARGET)  $(MANIFEST)  -C $(OUTPUT_PATH)/ .
	@bin/dx --dex --output=$(ANDROID_JAR_TARGET) $(JAR_TARGET)
	@echo "#!/system/bin/bash\n \
export CLASSPATH=$(INSTALL_PATH)$(ANDROID_JAR_TARGET)\n \
app_process $(INSTALL_PATH) $(MAIN_CLASS)\n" > $(RUN_SHELL_PATH)

	@echo "build finished ."



clean:
	@-rm -rf $(OUTPUT_PATH)
	@-rm $(JAR_TARGET)
	@-rm $(ANDROID_JAR_TARGET)
	@-rm $(RUN_SHELL_PATH)
	@-rm $(MANIFEST)
	@-rm $(FILE_LIST_NAME)
	@echo "clean finished ."


run:
	@adb wait-for-device
	@adb shell sh $(INSTALL_PATH)$(RUN_SHELL_PATH)



install:
	@adb wait-for-device
	@adb root
	@adb wait-for-device
	@adb remount
	@adb push $(ANDROID_JAR_TARGET) $(INSTALL_PATH)
	@adb push $(RUN_SHELL_PATH) $(INSTALL_PATH)


all:clean build install run
