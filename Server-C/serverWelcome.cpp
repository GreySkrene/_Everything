#include <iostream>
#include <fstream>
#include <string>
using namespace std;

#ifdef _MSC_VER
#define _CRTDBG_MAP_ALLOC
#include <crtdbg.h>
#define VS_MEM_CHECK _CrtSetDbgFlag(_CRTDBG_ALLOC_MEM_DF | _CRTDBG_LEAK_CHECK_DF);
#else
#define VS_MEM_CHECK
#endif

int main(int argc, char* argv[])
{
    VS_MEM_CHECK         // enable for memory leaks

    // open first argv or provided file for input
    istream& in = *(new ifstream(argc > 1 ? argv[1] : __FILE__));
    if (!in) return 1;

    // open second argv or cout for output
    ostream& out = (argc > 2) ? *(new ofstream(argv[2])) : cout;
    if (!out) return 2;

    // read input and send to output
    for (string line; getline(in, line);)
    {
        out << line << endl;
    }

    // recover IO object memory
    if (&in != &cin) delete(&in);
    if (&out != &cout) delete(&out);

    return 0;
}




/*
Argument Parsing Libraries: 
    Familiarize yourself with libraries like getopt and argp for parsing command-line arguments efficiently. 
    These libraries provide robust options for handling various argument types and formats.

Error Handling: 
    Learn how to implement robust error handling mechanisms, especially when parsing command-line arguments. 
    This includes detecting invalid input, providing informative error messages, and gracefully exiting the program.

Validation and Sanitization: 
    Ensure that input from command-line arguments is validated and sanitized to prevent security vulnerabilities and unexpected behavior.

Configuration Management: 
    Understand how to manage configurations through command-line arguments, including parsing configuration files and combining them with command-line options.

Usage Documentation: 
    Implement a clear and concise usage message that describes how to use the program, including all available options and arguments.

Testing: 
    Develop a comprehensive testing strategy to verify the correctness of your command-line parsing implementation under various scenarios, 
    including edge cases and invalid inputs.

Code Organization: 
    Organize your code in a modular and maintainable way, separating command-line parsing logic from other parts of the program.

Performance Optimization: 
    Consider performance implications when parsing command-line arguments, especially in programs that require frequent parsing or deal with large amounts 
    of data.

Cross-Platform Compatibility: 
    Ensure that your command-line parsing code is compatible with different operating systems and compilers, 
    considering differences in argument handling and behavior.

Documentation and Comments: 
    Document your code thoroughly, including comments that explain the purpose and behavior of each function and 
    section of code related to command-line parsing.
*/

/*
- Get your basic TCP sockets layer running (listen on port/ports, accept client connections and send/receive data).
- Implement a buffered reader so that you can read requests one line (delimited by CRLF) at a time.
- Read the very first line. Parse out the method, the request version and the path.
- Implement header parsing for the "Header: value" syntax. Don't forget unfolding folded headers.
- Check the request method, content type and content size to determine how/if the body will be read.
- Implement decoding of content based on content type.
- If you're going to support HTTP 1.1, implement things like "100 Continue", keep-alive, chunked transfer.
- Add robustness/security measures like detecting incomplete requests, limiting max number of clients etc.
- Shrink wrap your code and open-source it :)
*/