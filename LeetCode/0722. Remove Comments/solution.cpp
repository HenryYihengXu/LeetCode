class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        vector<string> result;
        int i = 0;
        string str = source.at(i);
        string newLine = "";
        bool toFindRight = false;
        while (i < source.size()) {
            if (toFindRight) {
                int rightBlockComment = str.find("*/");
                if (rightBlockComment != -1) {
                    toFindRight = false;
                    str = str.substr(rightBlockComment + 2, str.length() - rightBlockComment - 2);
                    if (str == "" && newLine != "") {
                        result.push_back(newLine);
                        newLine = "";
                    }
                } else {
                    str = "";
                }
            } else {
                int lineComment = str.find("//");
                int leftBlockComment = str.find("/*");
                // cout << leftBlockComment << endl;
                if (lineComment != -1 && leftBlockComment == -1 || lineComment != -1 && lineComment < leftBlockComment) {
                    if (newLine != "" && lineComment == 0) {
                        result.push_back(newLine);
                    } else if (lineComment != 0) {
                        result.push_back(newLine + str.substr(0, lineComment));
                    }
                    newLine = "";
                    str = "";
                } else if (leftBlockComment != -1 && lineComment == -1 || leftBlockComment != -1 && leftBlockComment < lineComment) {
                    newLine += str.substr(0, leftBlockComment);
                    str = str.substr(leftBlockComment + 2, str.length() - leftBlockComment - 2);
                    toFindRight = true;
                    // cout << str;
                } else {
                    result.push_back(newLine + str);
                    newLine = "";
                    str = "";
                }
            }
            if (str == "") {
                i += 1;
                if (i < source.size()) {
                    str = source.at(i);
                }
            }
        }
        return result;
    }
};
