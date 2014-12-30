<html>
<#import "spring.ftl" as spring/>
<body>
<form action="<@spring.url "/saveCongratulation" />" method="post" enctype="multipart/form-data">
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
                <input type="file" accept="image/jpeg" name="uploadPicture">
            </td>
        </tr>
        <tr>
            <td>
                <lable>Uplad audio mp3: </lable>
            </td>
            <td>
                <input type="file" accept="audio/mp3" name="uploadAudio">
            </td>
        </tr>
        <tr>
            <td>
                <lable>Uplad video mp4: </lable>
            </td>
            <td>
                <input type="file" accept="video/mp4" name="uploadVideo">
            </td>
        </tr>
        <tr>
            <td>
                <input type="Submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>