class Solution{
class TrieNode{
TrieNode[] child=new TrieNode[26];
int index=-1;
}
TrieNode root=new TrieNode();

public int[] stringIndices(String[] wordsContainer,String[] wordsQuery){

int minIndex=0;

for(int i=1;i<wordsContainer.length;i++){
if(wordsContainer[i].length()<wordsContainer[minIndex].length()){
minIndex=i;
}
}

root.index=minIndex;

for(int i=0;i<wordsContainer.length;i++){

String word=wordsContainer[i];
TrieNode node=root;

for(int j=word.length()-1;j>=0;j--){

int c=word.charAt(j)-'a';

if(node.child[c]==null){
node.child[c]=new TrieNode();
}

node=node.child[c];

if(node.index==-1||wordsContainer[i].length()<wordsContainer[node.index].length()){
node.index=i;
}
}
}

int[] ans=new int[wordsQuery.length];

for(int i=0;i<wordsQuery.length;i++){

String word=wordsQuery[i];
TrieNode node=root;
int res=root.index;

for(int j=word.length()-1;j>=0;j--){

int c=word.charAt(j)-'a';

if(node.child[c]==null){
break;
}

node=node.child[c];
res=node.index;
}

ans[i]=res;
}

return ans;
}
}