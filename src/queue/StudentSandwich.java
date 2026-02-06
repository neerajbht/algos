package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StudentSandwich {
    // using queue
    public int countStudentsQ(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> q = new LinkedList<>();
        for (int student : students) {
            q.offer(student);
        }

        int res = n;
        for (int sandwich : sandwiches) {
            int cnt = 0;
            while (cnt < n && q.peek() != sandwich) {
                q.offer(q.poll());
                cnt++;
            }
            if (q.peek() == sandwich) {
                q.poll();
                res--;
            } else {
                break;
            }
        }
        return res;
    }

    public int countStudentFq(int[] students, int[] sandwiches) {
        int n = students.length;
        /**
         * since stusdent are either 1,0 we have can use that to store totak student
         * neeed ing sandwichs
         */
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            cnt[students[i]]++; // count number of student in respective position we will only have 2 groups

        }
        int res = n; // all student
        // use this countto subtract
        for (int i = 0; i < n; i++) {
            if (cnt[sandwiches[i]] > 0) { // is that sandwich matching
                res--;
                cnt[sandwiches[i]]--;

            } else {
                break; // unmatched condition
            }
        }
        return res;

    }

    public static void main(String[] argds) {

        int[] students = { 1, 1, 0, 1, 1 };
        int[] sandwiches = { 0, 1, 0, 1, 1 };

        StudentSandwich st = new StudentSandwich();

        System.out.println("using queue " + st.countStudentsQ(students, sandwiches));

        System.out.println("using Frequency Count Method " + st.countStudentFq(students, sandwiches));

    }

}
