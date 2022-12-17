MAKEFLAGS += --silent
JC = javac
BUILD_PATH = ./build/

SOURCE_FILES = \
	src/RunClassicAlgorithm.java \
	src/RunTrieAlgorithm.java \
	src/edit_distance/EditDistanceOutput.java \
	src/edit_distance/Utils.java \
	src/edit_distance/ClassicAlgorithm.java \
	src/edit_distance/TrieAlgorithm.java \
	src/input/Input.java \
	src/trie/TrieNode.java \
	src/trie/Trie.java

build: $(SOURCE_FILES)
	javac -d $(BUILD_PATH) $(SOURCE_FILES)

run-p1:
	java -cp $(BUILD_PATH) RunClassicAlgorithm

run-p2:
	java -cp $(BUILD_PATH) RunTrieAlgorithm

# Replace with "rm -rf build" if on Linux
clean:
	rmdir /s /q build