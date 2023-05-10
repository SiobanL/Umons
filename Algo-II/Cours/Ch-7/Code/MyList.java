public interface MyList
{

    void     add(Object o);
    void     add(int i, Object o);
    Object   get(int i);
    //Iterator iterator();
    int      size();
    void     visit(MyVisitor v);

}
