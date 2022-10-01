// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i = 0; i<nums2.length; i++){
//             map.put(nums2[i], i);
//         }
        
//         for(int i = 0; i<nums1.length; i++){
//             if(map.containsKey(nums1[i])){
//                 int j = map.get(nums1[i]);
//                 int num = nums1[i];
//                 if(j == nums2.length-1)
//                     nums1[i] = -1;
//                 else{
//                     while(j<nums2.length){
//                         if(num < nums2[j]){
//                             nums1[i] = nums2[j];
//                             break;
//                         }
//                         else{
//                             nums1[i] = -1;
//                         }
//                         j++;
//                     }
//                 }
//             }
//             else{
//                 nums1[i] = -1;
//             }
//         }
//         return nums1;
//     }
// }

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<nums2.length; i++){
            while(!s.isEmpty() && s.peek() < nums2[i]){
                map.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
            
        }
        while(!s.isEmpty()){
            map.put(s.pop(), -1);
        }
        for(int i =0; i<nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}