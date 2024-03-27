#include <iostream>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <string>
using namespace std;

int main(int argc, char* argv[]) {
    int numStudents = 0;
    int numExams = 0;
    int** testScores;
    string* studentNames;

    // Parse info from input file.
    ifstream inputFile(argv[1]);
    inputFile >> numStudents >> numExams;
    inputFile.ignore(std::numeric_limits<int>::max(), '\n');

    // Initialize a double array.
    testScores = new int*[numStudents];
    for (int i = 0; i < numStudents; ++i) {
        testScores[i] = new int[numExams];
    }

    studentNames = new string[numStudents];

    for (int i = 0; i < numStudents; i++) {
        string line;
        getline(inputFile, line);
        istringstream iss(line);
        string name;
        iss >> name;
        studentNames[i] = name;
        for (int j = 0; j < numExams; j++) {
            iss >> testScores[i][j];
        }
    }
    inputFile.close();

    // Output students and scores.
    ofstream outputFile(argv[2]);
    outputFile << "Student Scores:" << endl;
    for (int i = 0; i < numStudents; i++) {
        outputFile << setw(20) << studentNames[i] << " ";
        for (int j = 0; j < numExams; j++) {
            outputFile << fixed << setprecision(0) << setw(5) << testScores[i][j] << " ";
        }
        outputFile << endl;
    }

    // Output Exam Averages
    outputFile << "Exam Averages:" << endl;
    double* examAverages = new double[numExams];
    for (int i = 0; i < numExams; i++) {
        double totalScore = 0;
        for (int j = 0; j < numStudents; j++) {
            totalScore += testScores[j][i];
        }
        examAverages[i] = totalScore / numStudents;
        outputFile << "    Exam " << i + 1 << " Average = " << fixed << setprecision(1) << examAverages[i] << endl;
    }

    // Output Student and Exam grades.
    outputFile << "Student Exam Grades:" << endl;
    for (int i = 0; i < numStudents; i++) {
        outputFile << setw(20) << studentNames[i] << " ";
        for (int j = 0; j < numExams; j++) {
            double studentScore = testScores[i][j];
            char grade;
            if (studentScore >= examAverages[j] + 15) {
                grade = 'A';
            } else if (studentScore >= examAverages[j] + 5) {
                grade = 'B';
            } else if (studentScore >= examAverages[j] - 5) {
                grade = 'C';
            } else if (studentScore >= examAverages[j] - 15) {
                grade = 'D';
            } else {
                grade = 'E';
            }
            outputFile << fixed << setprecision(0) << setw(5) << studentScore << "(" << grade << ") ";
        }
        outputFile << endl;
    }

    // Output A's B's and C's
    outputFile << "Exam Grades:" << endl;
    for (int i = 0; i < numExams; i++) {
        outputFile << "    Exam " << i + 1 << " Grades: ";
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        for (int j = 0; j < numStudents; j++) {
            double studentScore = testScores[j][i];
            if (studentScore >= examAverages[i] + 15) {
                a++;
            } else if (studentScore >= examAverages[i] + 5) {
                b++;
            } else if (studentScore >= examAverages[i] - 5) {
                c++;
            } else if (studentScore >= examAverages[i] - 15) {
                d++;
            } else {
                e++;
            }
        }
        outputFile << "A(" << a << ") B(" << b << ") C(" << c << ") D(" << d << ") E(" << e << ")" << endl;
    }

    // Calculate Averages
    double* studentAverages = new double[numStudents];
    double classAverage = 0;
    for (int i = 0; i < numStudents; i++) {
        double totalScore = 0;
        for (int j = 0; j < numExams; j++) {
            totalScore += testScores[i][j];
        }
        studentAverages[i] = totalScore / numExams;
        classAverage += studentAverages[i];
        outputFile << setw(20) << studentNames[i] << " " << fixed << setprecision(1) << studentAverages[i];
        if (studentAverages[i] >= classAverage / (i + 1) + 15) {
            outputFile << "(A)" << endl;
        } else if (studentAverages[i] >= classAverage / (i + 1) + 5) {
            outputFile << "(B)" << endl;
        } else if (studentAverages[i] >= classAverage / (i + 1) - 5) {
            outputFile << "(C)" << endl;
        } else if (studentAverages[i] >= classAverage / (i + 1) - 15) {
            outputFile << "(D)" << endl;
        } else {
            outputFile << "(E)" << endl;
        }
    }
    classAverage /= numStudents;
    outputFile << "Class Average Score = " << fixed << setprecision(1) << classAverage << endl;

    for (int i = 0; i < numStudents; ++i) {
        delete[] testScores[i];
    }
    delete[] testScores;
    delete[] studentNames;
    delete[] examAverages;
    delete[] studentAverages;

    return 0;
}
