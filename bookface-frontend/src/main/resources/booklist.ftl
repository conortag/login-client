<main id="content" role="main" xmlns="http://www.w3.org/1999/html">
       <table>
            <thead>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
           </thead>
           <tbody>
           <#list booklist as b>
           					<tr>
           						<td>${b.id}</td>
           						<td>${b.title}</td>
           						<td>${b.author}</td>
           					<tr></#list>
           </tbody>
       </table>
</main>