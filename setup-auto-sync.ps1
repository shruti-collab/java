# Setup auto-sync scheduled task
$ErrorActionPreference = "Stop"

try {
	$autoSyncPath = "c:\Users\shrut\OneDrive\Desktop\java\auto-sync.ps1"
	$taskAction = New-ScheduledTaskAction -Execute "powershell.exe" -Argument "-NoProfile -ExecutionPolicy Bypass -File `"$autoSyncPath`""
	$taskTrigger = New-ScheduledTaskTrigger -AtLogOn -User $env:USERNAME

	Register-ScheduledTask -TaskName "JavaRepoAutoSync" -Action $taskAction -Trigger $taskTrigger -Description "Auto-sync Java repository to GitHub" -Force | Out-Null

	Write-Host "Scheduled task 'JavaRepoAutoSync' created successfully." -ForegroundColor Green
	Write-Host "Auto-sync will start automatically when you log in." -ForegroundColor Cyan
}
catch {
	Write-Host "Failed to create scheduled task." -ForegroundColor Red
	Write-Host $_.Exception.Message -ForegroundColor Red
	exit 1
}
