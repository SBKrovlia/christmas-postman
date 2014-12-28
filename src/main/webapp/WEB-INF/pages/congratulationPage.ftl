<html>
<#import "spring.ftl" as spring/>
<body>
<form name="congrutulationForm" action="/saveCongratulation" method="post">
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
        <#--<tr>
            <td>
                <lable>Uplad picture jpg: </lable>
            </td>
            <td>
                <input type="file" accept="image/*"  &lt;#&ndash;onchange="showMyImage(this)"&ndash;&gt;
                       name="uploadPhoto" id="uploadPhoto" class="upload">
            </td>
        </tr>-->
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