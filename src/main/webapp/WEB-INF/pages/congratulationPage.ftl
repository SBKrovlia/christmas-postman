<html>
<#import "spring.ftl" as spring/>
<body>
<form action="/saveCongratulation" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                <label>Email: </label>
            </td>
            <td>
            <@spring.formInput  "congratulation.email" />
            </td>
        </tr>
        <tr>
            <td>
                <label>Text: </label>
            </td>
            <td>
            <@spring.formInput  "congratulation.text" />
            </td>
        </tr>
        <tr>
            <td>
                <lable>Uplad picture jpg: </lable>
            </td>
            <td>
                <input type="file" accept="image/*" name="uploadPicture">
            </td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>
                <input type="Submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>