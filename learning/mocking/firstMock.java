package mocking;

/**
 * Refer to http://mockito.googlecode.com/svn/tags/latest/javadoc/org/mockito/Mockito.html
 */

import static org.mockito.Mockito.*;

import java.util.List;

public class firstMock {
public static void main(String[] args) {
	 //mock creation
	 List mockedList = mock(List.class);

	 //using mock object
	 mockedList.add("one");
	 mockedList.clear();

	 //verification
	 verify(mockedList).add("one");
	 verify(mockedList).clear();
}
}
