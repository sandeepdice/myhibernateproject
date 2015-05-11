package ta.findcommonancestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFindCommonAncestor implements FindCommonAncestor {

    /**
     * returns common ancestor of two commits from a graph
     */
    public String findCommmonAncestor(final String [] commitHashes,
            final String [][] parentHashes, final String commitHash1,
            final String commitHash2) {
        String result = null;
        List<String> hashList = Arrays.asList(commitHashes);
        // continue only if either of commit hashes are null
        if (!hashList.isEmpty() || !(null == parentHashes)) {
            // if either of them is null, return either
            if (null == commitHash1  || null == commitHash2) {
                result = (null == commitHash1) ? commitHash2 : commitHash1;
            } else {
                // build ancestor tree of each commit
                List<String> ancestorList1 = buildAncestors(commitHash1, hashList, parentHashes);
                List<String> ancestorList2 = buildAncestors(commitHash2, hashList, parentHashes);
                
                // checking empty case to handle if both commits passed are root
                if (!(ancestorList1.isEmpty() && ancestorList2.isEmpty())) {
                    // if either of them is empty, get first of other
                    if (!ancestorList1.isEmpty() && ancestorList2.isEmpty()) {
                        result = ancestorList1.get(0);
                    } else if (!ancestorList2.isEmpty() && ancestorList1.isEmpty()) {
                        result = ancestorList2.get(0);
                    } else {
                        // get the first common commit from the two ancestor list
                        ancestorList1.retainAll(ancestorList2);
                        result = ancestorList1.get(0);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Builds ancestor list of a commit from commit graph
     * 
     * @param commitHash2
     * @param commitHashes
     * @param parentHashes
     * @return
     */
    private List<String> buildAncestors(final String commitHash2,
            final List<String> commitHashes, final String [][] parentHashes) {
        String parent;
        String tempHash = commitHash2;
        // return an empty object rather than a null
        List<String> returnList = new ArrayList<String>();
        while (null != tempHash
        		&& commitHashes.indexOf(tempHash) >= 0
                && null != parentHashes[commitHashes.indexOf(tempHash)]
                		// if parent hashes' size is greater than 0, iterate with 0th index
                && (null != (parent = parentHashes[commitHashes.indexOf(tempHash)][0]))) {
            returnList.add(parent);
            tempHash = parent;
        }
        return returnList;
    }
}
