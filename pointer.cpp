#include <iostream>
using namespace std;

main()
{
    // int a = 10;
    // int *p; // declare a pointer
    // p = &a; // assigning an address to the pointer
    // *p = 5; // assigning value for the variable that the pointer is saving its address

    // cout << p << endl
    //      << *p << endl;

    int a, b, c, d, sum;
    int *p1, *p2, *p3, *p4;
    p1 = &a;
    p2 = &b;
    p3 = &c;
    p4 = &d;
    cout << "Enter 3 values :" << endl;
    cin >> *p1 >> *p2 >> *p3;
    sum = *p1 + *p2 + *p3;
    cout << sum / 3;

    *p4 = *p1;
    *p1 = *p2;
    *p2 = *p3;
    *p3 = *p4;
}